import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddAssoComponent } from './add-asso.component';

describe('AddAssoComponent', () => {
  let component: AddAssoComponent;
  let fixture: ComponentFixture<AddAssoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddAssoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddAssoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
