import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GaussianBlurComponent } from './gaussian-blur.component';

describe('GaussianBlurComponent', () => {
  let component: GaussianBlurComponent;
  let fixture: ComponentFixture<GaussianBlurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GaussianBlurComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GaussianBlurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
