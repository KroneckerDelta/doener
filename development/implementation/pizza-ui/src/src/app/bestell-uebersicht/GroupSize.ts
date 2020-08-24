import { Pipe, PipeTransform } from '@angular/core';

import { Bestellung } from '../bestellung';

@Pipe({name: 'groupSizePipe'})
export class GroupSizePipe implements PipeTransform {
  public transform(bestellungen: Bestellung[], bestellung: string) {
    if (bestellungen) {

      return bestellungen.filter((b) => b.bestellung === bestellung).length;
    }
    return 0;
  }
}