import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AdminComponent } from './admin.component';
import { AdminRoutingModule } from './admin-routing.module';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { RegisterService } from './register/register.service';
import { AdminServiceService } from './adminlogin/services/admin-service.service';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { LocationComponent } from './location/location.component';
import { Admin2Component } from './admin2/admin2.component';

@NgModule({
  declarations: [
    AdminComponent,
    Admin2Component,
    HomeComponent,
    RegisterComponent,
    AdminloginComponent,
    LocationComponent,
  ],
  imports: [CommonModule, AdminRoutingModule, FormsModule, ReactiveFormsModule],
  bootstrap: [AdminComponent, Admin2Component],
  providers: [RegisterService, AdminServiceService],
})
export class AdminModule {}
