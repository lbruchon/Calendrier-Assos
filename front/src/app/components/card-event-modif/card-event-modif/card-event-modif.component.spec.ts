import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardEventModifComponent } from './card-event-modif.component';

describe('CardEventModifComponent', () => {
  let component: CardEventModifComponent;
  let fixture: ComponentFixture<CardEventModifComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardEventModifComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardEventModifComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
