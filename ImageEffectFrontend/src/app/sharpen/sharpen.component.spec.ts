import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SharpenComponent } from './sharpen.component';

describe('SharpenComponent', () => {
  let component: SharpenComponent;
  let fixture: ComponentFixture<SharpenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SharpenComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SharpenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
