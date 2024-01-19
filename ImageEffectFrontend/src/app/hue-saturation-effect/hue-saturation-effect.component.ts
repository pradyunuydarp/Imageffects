import { Component, OnInit, SecurityContext } from '@angular/core';
import { SafeUrl, DomSanitizer } from '@angular/platform-browser';
import { PhotoEffectService } from '../_services/photo-effect.service';

@Component({
  selector: 'app-hue-saturation-effect',
  templateUrl: './hue-saturation-effect.component.html',
  styleUrls: ['./hue-saturation-effect.component.scss']
})
export class HueSaturationEffectComponent implements OnInit {

  saturationAmount!: number;
  hueAmount!: number;
  selectedFile!: File;
  selectedImageUrl!: SafeUrl;
  resultImageUrl!: SafeUrl;

  constructor(
    private photoEffectService: PhotoEffectService,
    private sanitizer: DomSanitizer
  ) {
    this.saturationAmount = 100;
    this.hueAmount = 0;
  }

  ngOnInit(): void {
    
  }

  onFileSelected(event: any): void {
    this.selectedFile = event.target.files[0];
    this.selectedImageUrl = this.sanitizer.bypassSecurityTrustUrl(URL.createObjectURL(this.selectedFile));
  }

  applyHueSaturationEffect(): void {
    if (this.saturationAmount !== undefined && this.hueAmount !== undefined && this.selectedFile) {
      this.photoEffectService.applyHueSaturationEffect(this.hueAmount, this.saturationAmount, this.selectedFile)
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