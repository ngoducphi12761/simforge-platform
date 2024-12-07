import { Injectable } from '@angular/core';
import { FormControl, ValidationErrors } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class CfdFeaShopValidatorsService {
  static notOnlyWhitespace(control: FormControl) : ValidationErrors | null {
        
    // check if string only contains whitespace
    if ((control.value != null) && (control.value.trim().length === 0)) {

        // invalid, return error object
        return { 'notOnlyWhitespace': true };
    }
    else {
        // valid, return null
        return null;
    }
}
}
