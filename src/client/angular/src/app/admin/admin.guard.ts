import { inject } from '@angular/core';
import { CanActivateFn } from '@angular/router';

import { AdminService } from './admin.service';

export const adminGuard: CanActivateFn = (route, state) => {
  if (inject(AdminService).getIsLoggedIn) {
    return true
  }
  return false;
};
