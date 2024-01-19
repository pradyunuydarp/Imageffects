import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InvertComponent } from './invert.component';

describe('InvertComponent', () => {
  let component: InvertComponent;
  let fixture: ComponentFixture<InvertComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InvertComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InvertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
