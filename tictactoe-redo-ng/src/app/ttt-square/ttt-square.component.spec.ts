import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TttSquareComponent } from './ttt-square.component';

describe('TttSquareComponent', () => {
  let component: TttSquareComponent;
  let fixture: ComponentFixture<TttSquareComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TttSquareComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TttSquareComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
