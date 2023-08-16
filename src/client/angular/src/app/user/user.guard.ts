import { inject } from '@angular/core';
import { CanActivateFn } from '@angular/router';

import { UserService } from './user.service';

export const userGuard: CanActivateFn = (route, state) => {
  if (inject(UserService).isLoggedIn) {
    return true;
  }
  return false;
};
