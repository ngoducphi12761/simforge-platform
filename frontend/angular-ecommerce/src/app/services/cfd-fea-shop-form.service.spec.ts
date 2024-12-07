import { TestBed } from '@angular/core/testing';

import { CfdFeaShopFormService } from './cfd-fea-shop-form.service';

describe('CfdFeaShopFormService', () => {
  let service: CfdFeaShopFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CfdFeaShopFormService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
