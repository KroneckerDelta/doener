import { Component, Input, Optional } from '@angular/core';
import { NgForm, FormGroup, FormGroupDirective } from '@angular/forms';

@Component({
    selector: 'god-show-error',
    styleUrls: [
        'god-show-error.component.css'
    ],
    templateUrl: 'god-show-error.component.html'
})
export class GodShowErrorComponent {

    @Input('path') path;
    @Input('text') displayName = '';

    constructor( @Optional() private ngForm: NgForm,
        @Optional() private formGroup: FormGroupDirective
    ) {
    }

    get errorMessages(): string[] {
        let form: FormGroup;
        if (this.ngForm) {
            form = this.ngForm.form;
        } else {
            form = this.formGroup.form;
        }
        const control = form.get(this.path);
        const messages = [];

        if (!control || !control.errors || !control.dirty) {
            return null;
        }

        for (const code in control.errors) {
            if (control.errors.hasOwnProperty(code)) {
                const error = control.errors[code];
                let message = '';
                let i18nKey = { value: error.requiredLength };
                switch (code) {
                    case 'required':
                        message = `Dies ist ein Pflichtfeld.`;
                        break;
                    case 'minlength':
                        message = `Minimal`;
                        break;
                    case 'maxlength':
                        message = `Maximal`;
                        break;
                    case 'notANumber':
                        message = `${name} ist keine Währung`;
                        break;

                    default:
                        message = `${name} ist nicht valide`;
                }
                messages.push(message);
            }
        }
        return messages;
    }
}