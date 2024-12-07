import { TestBed } from '@angular/core/testing';

import { CfdFeaShopValidatorsService } from './cfd-fea-shop-validators.service';

describe('CfdFeaShopValidatorsService', () => {
  let service: CfdFeaShopValidatorsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CfdFeaShopValidatorsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
