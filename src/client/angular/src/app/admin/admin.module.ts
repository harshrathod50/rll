import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AdminComponent } from './admin.component';
import { AdminRoutingModule } from './admin-routing.module';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { RegisterService } from './register/register.service';

@NgModule({
  declarations: [AdminComponent, HomeComponent, RegisterComponent],
  imports: [CommonModule, AdminRoutingModule, FormsModule],
  bootstrap: [AdminComponent],
  providers: [RegisterService]
})
export class AdminModule {}
