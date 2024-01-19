import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BrightnessComponent } from './brightness.component';

describe('BrightnessComponent', () => {
  let component: BrightnessComponent;
  let fixture: ComponentFixture<BrightnessComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BrightnessComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BrightnessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
