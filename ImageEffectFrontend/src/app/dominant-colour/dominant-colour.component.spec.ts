import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DominantColourComponent } from './dominant-colour.component';

describe('DominantColourComponent', () => {
  let component: DominantColourComponent;
  let fixture: ComponentFixture<DominantColourComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DominantColourComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DominantColourComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
