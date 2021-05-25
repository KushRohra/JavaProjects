const passport = require("passport");
const GoogleStatergy = require("passport-google-oauth20").Strategy;
const mongoose = require("mongoose");
const keys = require("../config/keys");

const User = mongoose.model('users');

passport.use(new GoogleStatergy({
    clientID: keys.googleClientID,
    clientSecret: keys.googleClientSecret,
    callbackURL: "/auth/google/callback"
}, (accessToken, refreshToken, profile, done) => {
    User.findOne({ googleId: profile.id })
        .then((existingUser) => {
            if (existingUser) {
                // we already have a user with the profile ID
            } else {
                new User({ googleId: profile.id }).save();
            }
        })
    console.log(profile.id);
}));