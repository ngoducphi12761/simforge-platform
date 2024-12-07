export class Constant {
    // static readonly API_URL_V1_PREFIX = "http://localhost:8080/api";
   static readonly API_URL_V1_PREFIX  = "http://localhost:8888/api";
    
    static readonly purchaseUrl = `${Constant.API_URL_V1_PREFIX}/checkout/purchase`;
    static readonly baseUrl = `${Constant.API_URL_V1_PREFIX}/products`;
    static readonly categoryUrls =  `${Constant.API_URL_V1_PREFIX}/product-category`;
    static readonly countriesUrl = `${Constant.API_URL_V1_PREFIX}/countries`;
    static readonly statesUrl = `${Constant.API_URL_V1_PREFIX}/states`;
    static readonly securedEndpoints = `${Constant.API_URL_V1_PREFIX}/orders`;
    static readonly orderUrl = `${Constant.API_URL_V1_PREFIX}/orders`;
  }
  