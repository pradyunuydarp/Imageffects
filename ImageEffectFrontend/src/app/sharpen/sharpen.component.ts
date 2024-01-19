import { Component, OnInit, SecurityContext } from '@angular/core';
import { SafeUrl, DomSanitizer } from '@angular/platform-browser';
import { PhotoEffectService } from '../_services/photo-effect.service';

@Component({
  selector: 'app-sharpen',
  templateUrl: './sharpen.component.html',
  styleUrls: ['./sharpen.component.scss']
})
export class SharpenComponent implements OnInit {

  sharpenAmount!: number;
  selectedFile!: File;
  selectedImageUrl!: SafeUrl;
  resultImageUrl!: SafeUrl;

  constructor(
    private photoEffectService: PhotoEffectService,
    private sanitizer: DomSanitizer
  ) {
    this.sharpenAmount = 50; // Default value, adjust as needed
  }

  ngOnInit(): void {
    
  }

  onFileSelected(event: any): void {
    this.selectedFile = event.target.files[0];
    this.selectedImageUrl = this.sanitizer.bypassSecurityTrustUrl(URL.createObjectURL(this.selectedFile));
  }

  applySharpenEffect(): void {
    if (this.sharpenAmount !== undefined && this.selectedFile) {
      this.photoEffectService.applySharpenEffect(this.sharpenAmount, this.selectedFile)
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
