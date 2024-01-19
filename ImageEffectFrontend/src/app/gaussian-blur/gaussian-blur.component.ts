import { Component, OnInit, SecurityContext } from '@angular/core';
import { SafeUrl, DomSanitizer } from '@angular/platform-browser';
import { PhotoEffectService } from '../_services/photo-effect.service';

@Component({
  selector: 'app-gaussian-blur',
  templateUrl: './gaussian-blur.component.html',
  styleUrls: ['./gaussian-blur.component.scss']
})
export class GaussianBlurComponent implements OnInit {

  blurRadius!: number;
  selectedFile!: File;
  selectedImageUrl!: SafeUrl;
  resultImageUrl!: SafeUrl;

  constructor(
    private photoEffectService: PhotoEffectService,
    private sanitizer: DomSanitizer
  ) {
    this.blurRadius = 10; // Default value, adjust as needed
  }

  ngOnInit(): void {
    
  }

  onFileSelected(event: any): void {
    this.selectedFile = event.target.files[0];
    this.selectedImageUrl = this.sanitizer.bypassSecurityTrustUrl(URL.createObjectURL(this.selectedFile));
  }

  applyGaussianBlurEffect(): void {
    if (this.blurRadius !== undefined && this.selectedFile) {
      this.photoEffectService.applyGaussianBlurEffect(this.blurRadius, this.selectedFile)
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
