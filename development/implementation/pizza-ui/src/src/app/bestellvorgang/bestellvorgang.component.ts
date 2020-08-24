import * as process from 'process';
import { BestellungService } from '../bestellungService';
import { Bestellung } from '../bestellung';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Besteller } from '../besteller';

@Component({
  selector:    'bestellvorgang',
  templateUrl: './bestellvorgang.component.html',
  styleUrls:   ['./bestellvorgang.component.css']
})
export class BestellvorgangComponent implements OnInit {

  public besteller: Besteller;
  public anrufer: string;
  public bestellerVorhanden: boolean = this.besteller != null;

  public localState: any;
  public doenerLogo = 'assets/img/pizza.png';

  private bestellung: Bestellung = new Bestellung();

  constructor(public route: ActivatedRoute, private router: Router, private bestellungService: BestellungService) {
  }

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

  public setBesteller(name: String, raum: String) {
    this.besteller = new Besteller(name, raum);
    this.checkBesteller();
  }

  public checkBesteller() {
    if (this.besteller == null) {
      this.bestellerVorhanden = false;
    } else {
      this.bestellerVorhanden = true;
    }
  }

  public anruferSetzen() {
    const besteller : Besteller = new Besteller (
      this.anrufer,
       '1.12'
  );
    this.bestellungService.anruferSetzen(besteller);
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
