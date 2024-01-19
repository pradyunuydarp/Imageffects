import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GlobalService {
  rootUrl: string = environment.rootUrl;
  constructor() { }
}
