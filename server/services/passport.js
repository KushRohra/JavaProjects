const passport = require("passport");
const GoogleStatergy = require("passport-google-oauth20").Strategy;
const mongoose = require("mongoose");
const keys = require("../config/keys");

const User = mongoose.model('users');

passport.serializeUser((user, done) => {
    done(null, user.id);
});

passport.deserializeUser((id, done) => {
    User.findById(id)
        .then(user => {
            done(null, user);
        })
});

passport.use(new GoogleStatergy({
    clientID: keys.googleClientID,
    clientSecret: keys.googleClientSecret,
    callbackURL: "/auth/google/callback"
}, (accessToken, refreshToken, profile, done) => {
    User.findOne({ googleId: profile.id })
        .then((existingUser) => {
            if (existingUser) {
                // we already have a user with the profile ID
                done(null, existingUser);
            } else {
                // we dont have a record, make a new record
                new User({ googleId: profile.id })
                    .save()
                    .then(user => done(null, user));
            }
        })
    console.log(profile.id);
}));