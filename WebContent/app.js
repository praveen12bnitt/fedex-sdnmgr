/*
 * This file is generated and updated by Sencha Cmd. You can edit this file as
 * needed for your application, but these edits will have to be merged by
 * Sencha Cmd when upgrading.
 */
Ext.Loader.setConfig({
    enabled: true
});

Ext.Loader.addClassPathMappings({
  "SdnMgr": "app",
  "Ext": 'ext/src'
});
 
Ext.application({
    views: [
        'SdnMgr.view.main.Main',
        'SdnMgr.view.Header',
        'SdnMgr.view.CustomerPortal',
        'SdnMgr.view.CustomerDetail',
        'SdnMgr.view.CustomerAppInstance',
        'SdnMgr.view.CustomerAppInstanceDetail',
        'SdnMgr.view.LoginForm',
        'SdnMgr.view.AppFixPackList'
    ],
    models: [
        'SdnMgr.model.CustomerInstance',
        'SdnMgr.model.FixPack'
    ],
    stores: [
        'SdnMgr.store.CustomerInstance',
        'SdnMgr.store.FixPacks'
    ],
    name: 'SdnMgr',

    launch: function() {
        Ext.create('SdnMgr.view.main.Main');
    }

});
