import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Bestellung } from '../bestellung';
import { BestellungService } from '../bestellungService';

@Component({
  selector: 'bestellungen', // template: '<h1>BUUUH</h1>',
  templateUrl: './bestell-uebersicht.component.html',
  styleUrls: ['./bestell-uebersicht.component.css']
})
export class BestellUebersichtComponent implements OnInit {

  bestellungen: Bestellung[];
  selectedBestellung: Bestellung;

  constructor(private router: Router, private bestellungService: BestellungService) {
  }

  getBestellungen(): void {
    // this.bestellungen = this.bestellungService.getBestellungen();
    this.bestellungService.getBestellungen().then(b => {
      this.bestellungen = b;
    });
  }

  ngOnInit(): void {
    this.getBestellungen();
  }

  onSelect(bestellung: Bestellung): void {
    this.selectedBestellung = bestellung;
  }

  gotoDetail(): void {
    this.router.navigate([
      '/detail',
      this.selectedBestellung.id
    ]);
  }

  delete(bestellung: Bestellung): void {

    this.bestellungService
        .delete(bestellung.id)
        .then(() => {
          this.bestellungen = this.bestellungen.filter(h => h !== bestellung);
          if (this.selectedBestellung === bestellung) { this.selectedBestellung = null; }
        });
  }

  update(bestellung: Bestellung): void {
    bestellung.bezahlt = !bestellung.bezahlt;
    this.bestellungService.update(bestellung);
  }

  /**
   * Liefer die Summe an die GUI
   */
  getTotal() {
    let total: number = 0;
    if (this.bestellungen) {
      this.bestellungen.forEach(i => {
        let price = i.price;

        if (price) {
          let tmp: number = Number(price);
          if (tmp) {
            total += tmp;

          }
        }
      });
    }
    return total;
  }

}
