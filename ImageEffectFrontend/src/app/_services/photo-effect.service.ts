import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GlobalService } from './global-service.service';

@Injectable({
  providedIn: 'root'
})
export class PhotoEffectService {

  constructor(private http: HttpClient, private globalService: GlobalService) { }

  applyHueSaturationEffect(hueAmount: number, saturationAmount: number, imageFile: File): Observable<Blob> {
    const formData = new FormData();
    formData.append('hueAmount', hueAmount.toString());
    formData.append('saturationAmount', saturationAmount.toString());
    formData.append('imageFile', imageFile);

    const headers = new HttpHeaders();
    headers.set('Content-Type', 'multipart/form-data');
    
    return this.http.post<Blob>(`${this.globalService.rootUrl}/effect/hue-saturation`, formData, {
      headers: headers,
      responseType: 'blob' as 'json' // Specify response type as blob
    });
  }

  applyBrightnessEffect(amount: number, imageFile: File): Observable<Blob> {
    const formData = new FormData();
    formData.append('amount', amount.toString());
    formData.append('imageFile', imageFile);

    const headers = new HttpHeaders();
    headers.set('Content-Type', 'multipart/form-data');
    
    return this.http.post<Blob>(`${this.globalService.rootUrl}/effect/brightness`, formData, {
      headers: headers,
      responseType: 'blob' as 'json'
    });
  }

  applyContrastEffect(amount: number, imageFile: File): Observable<Blob> {
    const formData = new FormData();
    formData.append('amount', amount.toString());
    formData.append('imageFile', imageFile);

    const headers = new HttpHeaders();
    headers.set('Content-Type', 'multipart/form-data');
    
    return this.http.post<Blob>(`${this.globalService.rootUrl}/effect/contrast`, formData, {
      headers: headers,
      responseType: 'blob' as 'json'
    });
  }

  applyFlipEffect(horizontalFlipValue: number, verticalFlipValue: number, imageFile: File): Observable<Blob> {
    const formData = new FormData();
    formData.append('horizontalFlipValue', horizontalFlipValue.toString());
    formData.append('verticalFlipValue', verticalFlipValue.toString());
    formData.append('imageFile', imageFile);

    const headers = new HttpHeaders();
    headers.set('Content-Type', 'multipart/form-data');
    
    return this.http.post<Blob>(`${this.globalService.rootUrl}/effect/flip`, formData, {
      headers: headers,
      responseType: 'blob' as 'json'
    });
  }

  applyGaussianBlurEffect(radius: number, imageFile: File): Observable<Blob> {
    const formData = new FormData();
    formData.append('radius', radius.toString());
    formData.append('imageFile', imageFile);

    const headers = new HttpHeaders();
    headers.set('Content-Type', 'multipart/form-data');
    
    return this.http.post<Blob>(`${this.globalService.rootUrl}/effect/gaussian-blur`, formData, {
      headers: headers,
      responseType: 'blob' as 'json'
    });
  }

  applyGrayscaleEffect(imageFile: File): Observable<Blob> {
    const formData = new FormData();
    formData.append('imageFile', imageFile);

    const headers = new HttpHeaders();
    headers.set('Content-Type', 'multipart/form-data');
    
    return this.http.post<Blob>(`${this.globalService.rootUrl}/effect/grayscale`, formData, {
      headers: headers,
      responseType: 'blob' as 'json'
    });
  }

  applyInvertEffect(imageFile: File): Observable<Blob> {
    const formData = new FormData();
    formData.append('imageFile', imageFile);

    const headers = new HttpHeaders();
    headers.set('Content-Type', 'multipart/form-data');
    
    return this.http.post<Blob>(`${this.globalService.rootUrl}/effect/invert`, formData, {
      headers: headers,
      responseType: 'blob' as 'json'
    });
  }

  applyRotationEffect(value: number, imageFile: File): Observable<Blob> {
    const formData = new FormData();
    formData.append('value', value.toString());
    formData.append('imageFile', imageFile);

    const headers = new HttpHeaders();
    headers.set('Content-Type', 'multipart/form-data');
    
    return this.http.post<Blob>(`${this.globalService.rootUrl}/effect/rotation`, formData, {
      headers: headers,
      responseType: 'blob' as 'json'
    });
  }

  applySepiaEffect(imageFile: File): Observable<Blob> {
    const formData = new FormData();
    formData.append('imageFile', imageFile);

    const headers = new HttpHeaders();
    headers.set('Content-Type', 'multipart/form-data');
    
    return this.http.post<Blob>(`${this.globalService.rootUrl}/effect/sepia`, formData, {
      headers: headers,
      responseType: 'blob' as 'json'
    });
  }

  applySharpenEffect(amount: number, imageFile: File): Observable<Blob> {
    const formData = new FormData();
    formData.append('amount', amount.toString());
    formData.append('imageFile', imageFile);

    const headers = new HttpHeaders();
    headers.set('Content-Type', 'multipart/form-data');
    
    return this.http.post<Blob>(`${this.globalService.rootUrl}/effect/sharpen`, formData, {
      headers: headers,
      responseType: 'blob' as 'json'
    });
  }

  getDominantColour(imageFile: File): Observable<Blob> {
    const formData = new FormData();
    formData.append('imageFile', imageFile);

    const headers = new HttpHeaders();
    headers.set('Content-Type', 'multipart/form-data');
    
    return this.http.post<Blob>(`${this.globalService.rootUrl}/effect/dominant-colour`, formData, {
      headers: headers,
      responseType: 'blob' as 'json'
    });
  }
}
