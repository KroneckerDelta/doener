import { Directive } from '@angular/core';
import {
    AbstractControl,
    NG_VALIDATORS
} from '@angular/forms';

@Directive({
    selector: '[numberValidator]',
    providers: [{
        provide: NG_VALIDATORS,
        useExisting: NumberValidatorDirective, multi: true
    }]
})
export class NumberValidatorDirective {
    constructor() { }

    validate(control: AbstractControl): { [key: string]: any } {
        console.log('ich validiere');
        if (control.value || control.value === '' || control.value === NaN) {
            return null;
        }
        return { 'notANumber': true };
    }
}

