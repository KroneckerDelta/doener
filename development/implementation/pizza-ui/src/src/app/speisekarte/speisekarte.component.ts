import { Component, OnInit } from '@angular/core';

@Component({
  selector:    'speisekarte',
  templateUrl: './speisekarte.component.html',
  styleUrls:   ['./speisekarte.component.css']
})
export class SpeisekarteComponent implements OnInit {

  public vorn = 'assets/img/vorn.jpg';
  public hinten = 'assets/img/hinten.jpg';
  pdfSrc = "assets/pdf/Pizza.pdf";

  constructor() {
  }

  ngOnInit() {
  }

}
