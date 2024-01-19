import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SepiaComponent } from './sepia.component';

describe('SepiaComponent', () => {
  let component: SepiaComponent;
  let fixture: ComponentFixture<SepiaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SepiaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SepiaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
