import { Injectable, EventEmitter } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { PolicyOutputModel } from '../model/policy-output.model';
import { ApiResponseModel } from '../model/api-response.model';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class PolicyApiService {

  baseUrl: string = "http://localhost:8080/policy/";
  public newPolicyAdded = new EventEmitter<PolicyOutputModel>();

  constructor(private httpClient: HttpClient) { }

  public getAllPolicies(policyOutputModel: PolicyOutputModel) : Observable<ApiResponseModel>{
    return this.httpClient.post<ApiResponseModel>(this.baseUrl+'search',policyOutputModel,{
      headers: new HttpHeaders({
        'Access-Control-Allow-Origin': '*',
      })
    });
  }


  public savePolicy(customerOutputModel: PolicyOutputModel) : Observable<ApiResponseModel>{
  
    return this.httpClient.post<ApiResponseModel>(this.baseUrl+'save',customerOutputModel,{
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Access-Control-Allow-Origin': '*',

      })
    });
  }


  public deletePolicy(id:number) : Observable<ApiResponseModel>{
  
    return this.httpClient.delete<ApiResponseModel>(this.baseUrl+'delete/'+id,{
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Access-Control-Allow-Origin': '*',

      })
    });
  }

  public policyCustomers(id:number) : Observable<ApiResponseModel>{
  
    return this.httpClient.get<ApiResponseModel>(this.baseUrl+'policy-customer/'+id,{
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Access-Control-Allow-Origin': '*',

      })
    });
  }
}
