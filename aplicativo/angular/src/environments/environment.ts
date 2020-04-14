// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  PERSONA_HOST :'http://localhost:8081',
  PREFERENCIA_HOST:'http://localhost:8082',
  //PERSONA_HOST :'http://mybalancercf-151451967.us-east-2.elb.amazonaws.com',
  //PREFERENCIA_HOST:'http://mybalancercf-151451967.us-east-2.elb.amazonaws.com'
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
