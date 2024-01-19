import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LogModel } from '../_models/LogModel';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LogService {

  private baseUrl: String = environment.rootUrl + "/logs"
  constructor(private http: HttpClient) { }

  getAllLogs(): Observable<LogModel[]> {
    return this.http.get<LogModel[]>(`${this.baseUrl}`);
  }

  getLogsByEffect(effectName: string): Observable<LogModel[]> {
    return this.http.get<LogModel[]>(`${this.baseUrl}/${effectName}`);
  }

  clearLogs(): Observable<string> {
    return this.http.delete(`${this.baseUrl}`, {responseType: "text"});
  }

  getLogsBetweenTimestamps(startTime: string, endTime: string): Observable<LogModel[]> {
    const params = new HttpParams()
      .set('startTime', startTime)
      .set('endTime', endTime);
  
    return this.http.get<LogModel[]>(`${this.baseUrl}/between-timestamps`, { params });
  }
}
