import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { CustomerApiService } from '../services/customer-api.service';
import { CustomerOutputModel } from '../model/customer-output.model';
import { ApiResponseModel } from '../model/api-response.model';


@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent implements OnInit {


  constructor(private customerApiService: CustomerApiService) {
  }

  ngOnInit() {
   
  }

  onClickSubmit(formData: any) {
    const customerOutputModel :CustomerOutputModel = {
      id:null,
      tckNumber:formData.tckNumber,
      firstName:formData.firstName,
      lastName:formData.lastName,
      birthDate:formData.birthDate,
      address:formData.address,
      phoneNumber:formData.phoneNumber
    }
    console.log(customerOutputModel);
    this.customerApiService.saveUser(customerOutputModel).subscribe(
      data => {
        if(data.code == 200){
          alert("Kayıt işlemi başarılıyla gerçekleşmiştir ");
          this.customerApiService.newCustomerAdded.emit(<CustomerOutputModel>data.data);
          //this.registrationCustomer.emit(<CustomerOutputModel>data.data);
        }else{
          alert(data.error);
        }
      }
    );
 }
}
