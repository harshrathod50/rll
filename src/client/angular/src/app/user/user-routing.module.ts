import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserComponent } from './user.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { BusListComponent } from './bus/bus-list.component';
import { BookingComponent } from './booking/booking.component';
import { User2Component } from './user2/user2.component';
import { userGuard } from './user.guard';

const routes: Routes = [
  {
    path: '',
    component: UserComponent,
    children: [
      { path: '', component: HomeComponent },
      { path: 'bus', component: BusListComponent},
      { path: 'booking', component: BookingComponent},
    ],
    canActivate: [userGuard],
  },
  {
    path: '',
    component: User2Component,
    children: [
      { path: 'register', component: RegisterComponent },
      { path: 'login', component: LoginComponent },
    ],
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class UserRoutingModule {}
