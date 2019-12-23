import { Component, OnInit } from '@angular/core';
import { PolicyOutputModel } from 'src/app/model/policy-output.model';
import { PolicyApiService } from 'src/app/services/policy-api.service';

@Component({
  selector: 'app-policy-register',
  templateUrl: './policy-register.component.html',
  styleUrls: ['./policy-register.component.css']
})
export class PolicyRegisterComponent implements OnInit {

  constructor(private policyApiService:PolicyApiService) { }

  ngOnInit() {
  }




  onClickSubmit(formData: any){
    const policyOutputModel:PolicyOutputModel = {
      id:null,
      description:formData.description,
      productType:formData.productType,
      productName:formData.productName,
      expiry:formData.expiry,
      total:formData.total
    }

    console.log(policyOutputModel);

    this.policyApiService.savePolicy(policyOutputModel).subscribe(data => {
      if(data.code == 200){
        alert("Poliçe Kaydınız gerçekleşmiştir");
        console.log("register");
        console.log(data.data);
        this.policyApiService.newPolicyAdded.emit(<PolicyOutputModel>data.data);
      }else{
        alert(data.error);
      }
    });

  }

}
