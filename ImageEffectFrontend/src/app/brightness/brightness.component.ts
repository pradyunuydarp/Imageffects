import { Component, OnInit, SecurityContext } from '@angular/core';
import { SafeUrl, DomSanitizer } from '@angular/platform-browser';
import { PhotoEffectService } from '../_services/photo-effect.service';

@Component({
  selector: 'app-brightness',
  templateUrl: './brightness.component.html',
  styleUrls: ['./brightness.component.scss']
})
export class BrightnessComponent implements OnInit {
  brightnessAmount!: number;
  selectedFile!: File;
  selectedImageUrl!: SafeUrl;
  resultImageUrl!: SafeUrl;

  constructor(
    private photoEffectService: PhotoEffectService,
    private sanitizer: DomSanitizer
  ) {
    this.brightnessAmount = 100; // Default value, adjust as needed
  }

  ngOnInit(): void {
    
  }

  onFileSelected(event: any): void {
    this.selectedFile = event.target.files[0];
    this.selectedImageUrl = this.sanitizer.bypassSecurityTrustUrl(URL.createObjectURL(this.selectedFile));
  }

  applyBrightnessEffect(): void {
    if (this.brightnessAmount !== undefined && this.selectedFile) {
      this.photoEffectService.applyBrightnessEffect(this.brightnessAmount, this.selectedFile)
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
