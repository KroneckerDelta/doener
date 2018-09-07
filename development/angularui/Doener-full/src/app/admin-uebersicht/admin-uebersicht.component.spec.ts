import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminUebersichtComponent } from './admin-uebersicht.component';

/* tslint:disable:no-unused-variable */
describe('BestellUebersichtComponent', () => {
  let component: AdminUebersichtComponent;
  let fixture: ComponentFixture<AdminUebersichtComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [AdminUebersichtComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminUebersichtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
