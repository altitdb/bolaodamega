import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RaffledComponent } from './raffled.component';

describe('RaffledComponent', () => {
  let component: RaffledComponent;
  let fixture: ComponentFixture<RaffledComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RaffledComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RaffledComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
