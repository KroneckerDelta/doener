/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { BestellUebersichtComponent } from './bestell-uebersicht.component';

describe('BestellUebersichtComponent', () => {
  let component: BestellUebersichtComponent;
  let fixture: ComponentFixture<BestellUebersichtComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BestellUebersichtComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BestellUebersichtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
