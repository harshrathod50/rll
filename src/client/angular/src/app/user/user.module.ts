import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { UserComponent } from './user.component';
import { UserRoutingModule } from './user-routing.module';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { RegisterService } from './register/register.service';
import { LoginService } from './login/login.service';
import { HomeComponent } from './home/home.component';
import { BusListComponent } from './bus/bus-list.component';

@NgModule({
  declarations: [UserComponent, RegisterComponent, HomeComponent, LoginComponent, BusListComponent],
  imports: [CommonModule, UserRoutingModule, FormsModule],
  bootstrap: [UserComponent],
  providers: [RegisterService, LoginService],
})
export class UserModule { }
