import { Injectable, EventEmitter } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';

import { CustomerOutputModel } from '../model/customer-output.model';
import { ApiResponseModel} from '../model/api-response.model';
import { Observable } from 'rxjs';
import { CustomerPolicyOutputModel } from '../model/customer-policy-output.model';

@Injectable({
  providedIn: 'root'
})
export class CustomerApiService {

  baseUrl: string = "http://localhost:8080/customer/";

  newCustomerAdded = new EventEmitter<CustomerOutputModel>();
  newPolicyCustomerAdded = new EventEmitter<CustomerOutputModel>();
  customerOutputModel:CustomerOutputModel;

  constructor(private httpClient: HttpClient) { }

  public getAllCustomer(customerOutputModel: CustomerOutputModel) : Observable<ApiResponseModel>{
    return this.httpClient.post<ApiResponseModel>(this.baseUrl+'search',customerOutputModel,{
      headers: new HttpHeaders({
        'Access-Control-Allow-Origin': '*',
      })
    });
  }


  public saveUser(customerOutputModel: CustomerOutputModel) : Observable<ApiResponseModel>{
  
    return this.httpClient.post<ApiResponseModel>(this.baseUrl+'save',customerOutputModel,{
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Access-Control-Allow-Origin': '*',

      })
    });
  }


  public deleteUser(id:number) : Observable<ApiResponseModel>{
  
    return this.httpClient.delete<ApiResponseModel>(this.baseUrl+'delete/'+id,{
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Access-Control-Allow-Origin': '*',

      })
    });
  }

  public removeRelation(custId:number,policyId) : Observable<ApiResponseModel>{
    const body:CustomerPolicyOutputModel = {customerID: custId,policyID:policyId};
  
    return this.httpClient.post<ApiResponseModel>(this.baseUrl+'remove-customer-policy/',body,{
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Access-Control-Allow-Origin': '*',

      })
    });
  }

  public addRelation(custId:number,policyId:number) : Observable<ApiResponseModel>{
    const body:CustomerPolicyOutputModel = {customerID: custId,policyID:policyId};
  
    return this.httpClient.post<ApiResponseModel>(this.baseUrl+'add-customer-policy/',body,{
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Access-Control-Allow-Origin': '*',

      })
    });
  }
}


