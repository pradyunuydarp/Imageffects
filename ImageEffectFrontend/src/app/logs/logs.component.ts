import { Component, OnInit } from '@angular/core';
import { LogModel } from '../_models/LogModel';
import { LogService } from '../_services/log.service';
import { HttpErrorResponse } from '@angular/common/http';
import { catchError, of } from 'rxjs';

@Component({
  selector: 'app-logs',
  templateUrl: './logs.component.html',
  styleUrls: ['./logs.component.scss']
})
export class LogsComponent implements OnInit {

  logs: LogModel[] = [];
  effectNameFilter: string = '';
  startTime: string = '';
  endTime: string = '';

  constructor(private logService: LogService) { }

  ngOnInit(): void {
    this.loadLogs();
  }

  loadLogs() {
    this.logService.getAllLogs()
      .pipe(
        catchError(
          (err: HttpErrorResponse) => {
            console.log("Some error occured.")
            return of(false);
          }
        )
      )
      .subscribe(
        (data: Boolean | LogModel[]) => {
          if (data) {
            this.logs = <LogModel[]>data;
          }
        }
      );
  }

  filterLogsByEffect() {
    if (this.effectNameFilter) {
      this.logService.getLogsByEffect(this.effectNameFilter)
        .pipe(
          catchError(
            (err: HttpErrorResponse) => {
              console.log("Some error occured.")
              return of(false);
            }
          )
        )
        .subscribe(
          (data: Boolean | LogModel[]) => {
            if (data) {
              this.logs = <LogModel[]>data;
            }
          }
        );
    } else {
      this.loadLogs();
    }
  }

  clearLogs() {
    // Call the clearLogs method from the LogService
    this.logService.clearLogs()
    .pipe(
      catchError(
        (err: HttpErrorResponse) => {
          console.error('Failed to clear logs:', err);
          return of(false);
        }
      )
    )
    .subscribe(
      (response) => {
        if (response) {
          console.log('Logs cleared successfully:', response);
          this.loadLogs();
        }
      }
    );
  }

  // New function to load logs between timestamps
  loadLogsBetweenTimestamps() {
    if (this.startTime && this.endTime) {
      this.logService.getLogsBetweenTimestamps(this.startTime, this.endTime)
        .pipe(
          catchError(
            (err: HttpErrorResponse) => {
              console.error('Failed to retrieve logs between timestamps:', err);
              return of(false);
            }
          )
        )
        .subscribe(
          (data: LogModel[] | Boolean) => {
            if (data) {
              this.logs = <LogModel[]>data;
            }
          }
        );
    }
  }
  
}
