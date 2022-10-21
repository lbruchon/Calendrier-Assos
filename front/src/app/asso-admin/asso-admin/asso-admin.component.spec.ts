import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssoAdminComponent } from './asso-admin.component';

describe('AssoAdminComponent', () => {
  let component: AssoAdminComponent;
  let fixture: ComponentFixture<AssoAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssoAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AssoAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
