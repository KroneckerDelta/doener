/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpeisekarteComponent } from './speisekarte.component';

describe('SpeisekarteComponent', () => {
  let component: SpeisekarteComponent;
  let fixture: ComponentFixture<SpeisekarteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [SpeisekarteComponent]
    })
           .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpeisekarteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
