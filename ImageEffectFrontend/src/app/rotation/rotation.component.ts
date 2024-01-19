import { Component, OnInit, SecurityContext } from '@angular/core';
import { SafeUrl, DomSanitizer } from '@angular/platform-browser';
import { PhotoEffectService } from '../_services/photo-effect.service';

@Component({
  selector: 'app-rotation',
  templateUrl: './rotation.component.html',
  styleUrls: ['./rotation.component.scss']
})
export class RotationComponent implements OnInit {

  selectedFile!: File;
  selectedImageUrl!: SafeUrl;
  resultImageUrl!: SafeUrl;
  rotationLevel: number = 0; // Initial rotation level

  constructor(
    private photoEffectService: PhotoEffectService,
    private sanitizer: DomSanitizer
  ) { }

  ngOnInit(): void {}

  onFileSelected(event: any): void {
    this.selectedFile = event.target.files[0];
    this.selectedImageUrl = this.sanitizer.bypassSecurityTrustUrl(URL.createObjectURL(this.selectedFile));
  }

  rotateClockwise(degrees: number): void {
    // Set the rotation level
    this.rotationLevel = degrees;
  }

  applyRotationEffect(): void {
    if (this.rotationLevel !== undefined && this.selectedFile) {
      // Convert rotation level to values 0, 1, 2, 3
      const rotationValue = this.rotationLevel / 90;

      this.photoEffectService.applyRotationEffect(rotationValue, this.selectedFile)
        .subscribe((result: Blob) => {
          const url = this.sanitizer.bypassSecurityTrustUrl(URL.createObjectURL(result));
          this.resultImageUrl = url;
        });
    }
  }

  downloadResultImage(): void {
    if (this.resultImageUrl) {
      const url = this.sanitizer.sanitize(SecurityContext.URL, this.resultImageUrl);
      const link = document.createElement('a');
      link.href = <string>url;
      link.download = 'result_image.png';
      document.body.appendChild(link);
      link.click();
      document.body.removeChild(link);
    }
  }

}