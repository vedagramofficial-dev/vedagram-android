# Vedagram Android Starter

A clean, independently written Android starter for **Vedagram**. This repository does not copy Finegram's compiled APK or its source code.

## What's included
- Vedagram name and custom purple paper-plane-inspired vector launcher icon
- Matching splash screen and shared dark-purple theme
- Russian-language interface labels and sample chats
- Dark chat-list UI prototype with purple accents
- Search field and sample chat rows
- GitHub Actions workflow that builds and uploads a debug APK
- Android package: `com.vedagram.app`

## Build an APK on GitHub
1. Create a new GitHub repository named `vedagram-android`.
2. Upload the contents of this folder (the files inside the folder, not the outer folder).
3. Open **Actions** and enable workflows if GitHub asks.
4. Open **Build Vedagram APK** and choose **Run workflow**, or push a commit to `main`.
5. When the run finishes successfully, open the run and download the `Vedagram-debug-apk` artifact.
6. Extract the ZIP artifact; install `app-debug.apk` on your Android device.

## Important status
This is the first visual/buildable prototype, **not yet a working Telegram client**. The sample chats are local placeholders. Real messaging requires a Telegram API/TDLib integration, app credentials obtained from Telegram, secure session handling, and additional implementation/testing. Never commit API hashes, tokens, or user session data to the repository.

## Branding
- App label: Vedagram
- Package: `com.vedagram.app`
- Accent: `#7C2CFF`
- Background: `#121224`

## Next milestones
1. Replace sample rows with real chat data.
2. Integrate Telegram's supported API/TDLib after reviewing its terms and licensing.
3. Add contacts, chat screen, message composer, media uploads/downloads, notifications, and settings.
4. Create a signed release build for distribution (the current workflow intentionally produces a debug APK).
