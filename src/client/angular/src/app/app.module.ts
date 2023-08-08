import { NgModule, Component } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule, } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { RegisterComponent } from './register/register.component';
import {  HttpClientModule } from '@angular/common/http';
import { AdminComponent } from './admin/admin.component';
import { UserLoginComponent } from './user-login/user-login.component';
<<<<<<< Updated upstream
import { UserloginService } from './user-login/userlogin.service';
=======
import { UserService } from './user/user.service';
>>>>>>> Stashed changes


@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    RegisterComponent,
    AdminComponent,
    UserLoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
<<<<<<< Updated upstream
  providers: [UserloginService],
=======
  providers: [UserService],
>>>>>>> Stashed changes
  bootstrap: [AppComponent]
})
export class AppModule { }
