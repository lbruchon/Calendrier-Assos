import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CartEventAdminComponent } from './cart-event-admin.component';

describe('CartEventAdminComponent', () => {
  let component: CartEventAdminComponent;
  let fixture: ComponentFixture<CartEventAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CartEventAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CartEventAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
