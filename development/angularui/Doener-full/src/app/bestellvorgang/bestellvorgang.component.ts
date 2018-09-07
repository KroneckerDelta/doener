import * as process from 'process';
import * as webpack from 'webpack';
import { BestellungService } from '../bestellungService';
import { Bestellung } from '../bestellung';
import { Component, Host, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from 'angular2/common';

@Component({
  selector: 'bestellvorgang',
  templateUrl: './bestellvorgang.component.html',
  styleUrls: ['./bestellvorgang.component.css']
})
export class BestellvorgangComponent implements OnInit {


  public localState: any;
  public doenerLogo = 'assets/img/doener.png';

  private bestellung: Bestellung = new Bestellung();

  constructor(
    public route: ActivatedRoute,
    private router: Router,
    private bestellungService: BestellungService) { }


  public ngOnInit() {
    console.log('env: ', process.env);
    this.route
      .data
      .subscribe((data: any) => {
        /**
         * Your resolved data from route.
         */
        this.localState = data.yourData;
      });

    console.log('hello `About` component');
    /**
     * static data that is bundled
     * var mockData = require('assets/mock-data/mock-data.json');
     * console.log('mockData', mockData);
     * if you're working with mock data you can also use http.get('assets/mock-data/mock-data.json')
     */
    this.asyncDataWithWebpack();
  }

  public saveBestellung(bestellung: Bestellung) {
    console.log('Save Bestellung: ', bestellung);
    if (bestellung) {
      this.bestellungService.create(bestellung).then(() => {
        this.gotoUebersicht();
      });
    }

  }

  private asyncDataWithWebpack() {
    /**
     * you can also async load mock data with 'es6-promise-loader'
     * you would do this if you don't want the mock-data bundled
     * remember that 'es6-promise-loader' is a promise
     */
    setTimeout(() => {

      System.import('../../assets/mock-data/mock-data.json')
        .then((json) => {
          console.log('async mockData', json);
          this.localState = json;
        });

    });
  }

  private gotoUebersicht(): void {
    this.router.navigate(['/bestellungen']);
  }
}
