import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './user/user.component';
import { RegisterComponent } from './register/register.component';
import { AdminComponent } from './admin/admin.component'
import { UserLoginComponent } from './user-login/user-login.component';

const routes: Routes = [
  { path: 'user/register', component: UserComponent },
  { path: 'admin/register',component:RegisterComponent },
  { path: 'adminlogin', component: AdminComponent },
  {path: 'userlogin',component:UserLoginComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
