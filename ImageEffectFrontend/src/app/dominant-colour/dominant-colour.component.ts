import { Component, OnInit, SecurityContext } from '@angular/core';
import { PhotoEffectService } from '../_services/photo-effect.service';
import { SafeUrl, DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-dominant-colour',
  templateUrl: './dominant-colour.component.html',
  styleUrls: ['./dominant-colour.component.scss']
})
export class DominantColourComponent implements OnInit {
  selectedFile!: File;
  selectedImageUrl!: SafeUrl;
  resultImageUrl!: SafeUrl;

  constructor(
    private photoEffectService: PhotoEffectService,
    private sanitizer: DomSanitizer
  ) { }

  ngOnInit(): void { }

  onFileSelected(event: any): void {
    this.selectedFile = event.target.files[0];
    this.selectedImageUrl = this.sanitizer.bypassSecurityTrustUrl(URL.createObjectURL(this.selectedFile));
  }

  applyEffect(): void {
    if (this.selectedFile) {
      this.photoEffectService.getDominantColour(this.selectedFile)
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
