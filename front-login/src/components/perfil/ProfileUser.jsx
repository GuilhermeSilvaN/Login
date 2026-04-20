import '../../style/theme.css' // variavel de css;
import './ProfileUser.css' //css onde utiliza as variaveis;


function ProfileUser({profile}){
    const {name, bio, dia, numbers} = profile;

    return (
        <div className='container-prof'>
            <h1>{name}</h1>
            <p>{bio}</p>
            <p>
                nada a ver
            </p>

        </div>
    )
}

export default ProfileUser;