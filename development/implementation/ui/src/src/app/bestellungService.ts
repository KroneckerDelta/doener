import 'rxjs/add/operator/toPromise';

import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import { Bestellung } from './bestellung';

@Injectable()
export class BestellungService {

  private bestellungenUrl = '/api/findHeute';
  private saveUrl = '/api/save';
  private updateUrl = '/api/bestellung';
  private deleteUrl = '/api/bestellung/';
  private anruferUrl = '/api/anrufer/';
  private headers = new Headers({'Content-Type': 'application/json'});

  constructor(private http: Http) {
  }

  getBestellung(id: number): Promise<Bestellung> {
    console.log('hole Bestellungen');
    const url = `${this.bestellungenUrl}/${id}`;
    console.log('hole Bestellungen url: ', url);

    return this.http.get(url)
               .toPromise()
               .then(response => response.json().data as Bestellung)
               .catch(this.handleError);

  }

  getBestellungen(): Promise<Bestellung[]> {
    console.log('Hole daten vom server');

    return this.http.get(this.bestellungenUrl).toPromise()
               .then(response => {
                 let b = response.json() as Bestellung[];
                 return b;
               }).catch(this.handleError);

    //  .toPromise()
    //  .then(response => response.json().data as Bestellung[])
    //  .catch(this.handleError);

  }

  update(bestellung: Bestellung): Promise<Bestellung> {
    console.log('Meine Bestellung: ' + bestellung);
    const url = `${this.updateUrl}`;
    return this.http
               .put(url, JSON.stringify(bestellung), {headers: this.headers})
               .toPromise()
               .then(() => bestellung)
               .catch(this.handleError);
  }

  create(bestellung: Bestellung): Promise<Bestellung> {
    console.log('Versuche Bestellung zu erstellen');
    let bestellungAsJSON = JSON.stringify(bestellung);
    console.log('JSON BEstellung', bestellungAsJSON);
    return this.http
               .post(this.saveUrl, bestellungAsJSON, {headers: this.headers})
               .toPromise()
               .then(res => res.json().data as Bestellung)
               .catch(this.handleError);
  }

  delete(id: number): Promise<void> {
    const url = `${this.deleteUrl}/${id}`;
    return this.http.delete(url, {headers: this.headers})
               .toPromise()
               .then(() => null)
               .catch(this.handleError);

  }

  anruferSetzen(anrufer: string): any {
    console.log('Setze Anrufer');
    return this.http
               .post(this.anruferUrl + anrufer, {headers: this.headers})
               .toPromise()
               .then(res => res.json().data as Bestellung)
               .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
